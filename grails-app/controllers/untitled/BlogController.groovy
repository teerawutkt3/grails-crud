package untitled

import org.springframework.web.servlet.ModelAndView

class BlogController {

    BlogService blogService

    def index(Blog blog) {
        ModelAndView mav = new ModelAndView("/blog/index.gsp")

        try {
            def list = blogService.show(blog)
            mav.addObject("blog", blog != null ? blog : new Blog())
            mav.addObject("list", list)

        } catch (Exception e) {
            e.printStackTrace()
        }

        return mav
    }

    def save(Blog blog) {
        try {
            blogService.save(blog)
        } catch (Exception e) {
            e.printStackTrace()
        }
        redirect action: 'index', controller: 'blog'
    }

    def create() {
        ModelAndView mav = new ModelAndView("/blog/form.gsp")
        try {
            mav.addObject("blog", new Blog())
        } catch (Exception e) {
            e.printStackTrace()
        }
        return mav
    }

    def update(long id) {
        ModelAndView mav = new ModelAndView("/blog/form.gsp")
        try {
            def blog = Blog.get(id)
            mav.addObject("blog", blog)
        } catch (Exception e) {
            e.printStackTrace()
        }
        return mav
    }

    def delete(long id) {
        try {
            blogService.delete(id)
        } catch (Exception e) {
            e.printStackTrace()
        }
        redirect action: 'index', controller: 'blog'
    }
}
