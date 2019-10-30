package untitled

class Blog {

    static constraints = {

        title maxSize: 255
        description maxSize: 2000
        dateCreated  nullable: true
        lastUpdated nullable: true
    }

    String title
    String description
    Date dateCreated
    Date lastUpdated
}
