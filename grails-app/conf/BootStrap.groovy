import qotd.Quote

class BootStrap {

    def init = { servletContext ->
        def quote1 = new Quote(author: 'McGregor', content: "These featherweights don't understand...").save()

        def quote2 = new Quote(author: 'Brock Lesnar', content: 'Can you see me now???').save()

    }
    def destroy = {
    }
}
