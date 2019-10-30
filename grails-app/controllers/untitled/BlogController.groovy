package untitled

import org.springframework.web.servlet.ModelAndView

class BlogController {

    BlogService blogService

    def index(Blog blog) {
        def list = blogService.show(blog)
        ModelAndView mav = new ModelAndView("/blog/index.gsp")
        mav.addObject("blog", blog)
        mav.addObject("list", list)
        return mav
    }

    def save(Blog blog){
        try {
            blogService.save(blog)
        }catch(Exception e){
            e.printStackTrace()
        }
        redirect action:'index', controller: 'blog'
    }

    def create(){
        ModelAndView mav = new ModelAndView("/blog/form.gsp")
        mav.addObject("blog", new Blog())
        return  mav
    }
    def update(long id){
        ModelAndView mav = new ModelAndView("/blog/form.gsp")
        def blog = Blog.get(id)
        mav.addObject("blog", blog)
    return mav
}
    def delete(long id){
        try {
            blogService.delete(id)
        }catch(Exception e){
            e.printStackTrace()
        }
        redirect action:'index', controller: 'blog'
    }
}
