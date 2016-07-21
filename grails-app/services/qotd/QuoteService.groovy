package qotd

import grails.transaction.Transactional

@Transactional
class QuoteService {

    def serviceMethod() {

    }

    def getStaticQuote() {
        return new Quote(author: "Anonymous", content: "Real Programmers don't eat much Quiche")
    }

    def getRandomQuote() {
        def quotes = Quote.list()

        if (quotes.size() > 0) {
            def randomNum = random.nextInt(quotes.size())

            return quotes.get(randomNum)
        } else {
            return getStaticQuote()
        }
    }

    Random random = new Random()
}
