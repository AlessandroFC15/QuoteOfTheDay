package qotd

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class QuoteAnalyzerSpec extends Specification {
    @Shared quotes = [
            new Quote(author: "Peter Ledbrook",
                    content: "Time waits for no man"),
            new Quote(author: "Glen Smith",
                    content: "Groovy solves all problems")
    ]

    @Shared quotesX = [
            new Quote(author: "Peter Ledbrook",
                    content: "Time waits for no man"),
            new Quote(author: "Glen Smith",
                    content: "Groovy solves all problems"),
            new Quote(author: "Peter Ledbrook",
                    content: "Time waits for no man"),
            new Quote(author: "Glen Smith",
                    content: "Groovy solves all problems")
    ]

    @Unroll
    def "Total number of quotes"() {
        given: "An analyzer initialized with known quotes"
        def analyzer = new QuoteAnalyzer(inputQuotes)

        when: "I ask for the quote count"
        def quoteCount = analyzer.quoteCount

        then: "The number of quotes in the test list is returned"
        quoteCount == expected

        where:
            inputQuotes | expected
            quotes      | 2
            []          | 0
            quotesX     | 4
    }

    def "Number of Quotes p/ Author"() {
        given: "An analyzer initialized with known quotes"
        def analyzer = new QuoteAnalyzer(inputQuotes)

        when: "I ask for the number of quotes per author"
        def numberOfQuotesPerAuthor = analyzer.numberOfQuotesPerAuthor

        then: "The correct map is returned"
        numberOfQuotesPerAuthor == expected

        where:
        inputQuotes | expected
        []          | [:]
        quotes      | ['Peter Ledbrook': 1, 'Glen Smith': 1]
        quotesX     | ['Peter Ledbrook': 2, 'Glen Smith': 2]
    }
}
