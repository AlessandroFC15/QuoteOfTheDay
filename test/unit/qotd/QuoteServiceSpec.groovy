package qotd

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(QuoteService)
class QuoteServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test quote service always returns same static quote"() {
        when:
            Quote quote = service.getStaticQuote()

        then:
            quote.author == "Anonymous"
            quote.content == "Real Programmers don't eat much Quiche"
    }
}
