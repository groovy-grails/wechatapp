package weichatapp



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class WebPageController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond WebPage.list(params), model:[webPageInstanceCount: WebPage.count()]
    }

    def show(WebPage webPageInstance) {
        respond webPageInstance
    }

    def create() {
        respond new WebPage(params)
    }

    @Transactional
    def save(WebPage webPageInstance) {
        if (webPageInstance == null) {
            notFound()
            return
        }

        if (webPageInstance.hasErrors()) {
            respond webPageInstance.errors, view:'create'
            return
        }

        webPageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'webPage.label', default: 'WebPage'), webPageInstance.id])
                redirect webPageInstance
            }
            '*' { respond webPageInstance, [status: CREATED] }
        }
    }

    def edit(WebPage webPageInstance) {
        respond webPageInstance
    }

    @Transactional
    def update(WebPage webPageInstance) {
        if (webPageInstance == null) {
            notFound()
            return
        }

        if (webPageInstance.hasErrors()) {
            respond webPageInstance.errors, view:'edit'
            return
        }

        webPageInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'WebPage.label', default: 'WebPage'), webPageInstance.id])
                redirect webPageInstance
            }
            '*'{ respond webPageInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(WebPage webPageInstance) {

        if (webPageInstance == null) {
            notFound()
            return
        }

        webPageInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'WebPage.label', default: 'WebPage'), webPageInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'webPage.label', default: 'WebPage'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
