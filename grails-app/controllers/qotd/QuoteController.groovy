package qotd

class QuoteController {

    def scaffold = Quote

    def quoteService

    static defaultAction = "home"

    def home() {
        render "<h1> Nate's long skinny fat body!</h1>"
    }

    def random() {
        def staticQuote = quoteService.getRandomQuote()

        [ quote : staticQuote]
    }

    def ajaxRandom() {
        def randomQuote = quoteService.getRandomQuote()

        render {
            q(randomQuote.content)
            p(randomQuote.author)
        }
    }
}
