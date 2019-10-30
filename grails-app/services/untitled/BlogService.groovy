package untitled

import grails.gorm.transactions.Transactional

@Transactional
class BlogService {

    def show(Blog blog) {
        def result = Blog.createCriteria().list{
            if (blog != null){
                if (blog.getTitle() != null && blog.getTitle() != ""){
                    like ('title', "%"+blog.getTitle()+"%")
                }
                if (blog.getDescription() != null && blog.getDescription() != ""){
                    like ('description',"%"+ blog.getDescription()+"%")
                }
            }
        }
        return result
    }

    def save(Blog blog) {

        if (!blog.save()) {
            println("Save Fail!")
            log.info(this.getClass().getName() + "::Fail!")
        }else{
            println("Save Success")
        }
    }

    def delete(long id) {
        println(this.getClass().getName()+" => Delete id: " + id)
        Blog.findById(id).delete()
    }
}
