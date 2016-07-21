import qotd.*

def analyzer = new QuoteAnalyzer(Quote.list())

try {
    def reportFile = new File("report.txt")
    reportFile.withPrintWriter { w ->
        w.println """\
Quote report
------------

Total: ${analyzer.quoteCount}
Number of quotes by author:
        """
            for (entry in analyzer.numberOfQuotesPerAuthor) {
                w.println ">> " + entry.key.padRight(20) + entry.value
            }
        }
        
        println reportFile.text 
}
catch (IOException ex) {
    println "Unable to write to the 'report.txt' file!"
}