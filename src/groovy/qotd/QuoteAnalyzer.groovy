package qotd

class QuoteAnalyzer {
    private final List<Quote> quotes

    QuoteAnalyzer(List<Quote> quotes) {
        this.quotes = new ArrayList<>(quotes)
    }

    def getQuoteCount() {
        return quotes? quotes.size() : 0
    }

    def getNumberOfQuotesPerAuthor() {
        def authors = [:]

        quotes.each{ quote ->
            def author = quote.author

            if (authors[author]) {
                authors[author] += 1
            } else {
                authors[author] = 1
            }
        }

        return authors
    }
}
