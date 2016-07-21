import qotd.*

/* Take a set of quote parts (a subject, a verb,
and an object) and randomly combine them into distinct quotes. You then attribute
each quote to a randomly selected author. The initial iteration of this script prints the
generated quotes. */

def authors = ['Shakespeare', 'ET', 'Dana White', 'Joe Rogan']

def subjects = ["Alessandro", "Conor McGregor", "Mystic Mac", "Nate Diaz", "The Notorious One"]

def verbs = ["eats", "fights", "trains", "is training", "is fighting", "is eating", 'is working']

def complements = ['like a pussy', 'like a bear', 'like a motherfucker', 'like a bum', 'like a little girl']

def numberOfQuotes = 3

return translateSentenceToPigLatin('happy duck glove')

numberOfQuotes.times {
    println getRandomQuote(subjects, verbs, complements, authors)
}

def getRandomQuote(subjects, verbs, complements, authors) {
    def randomContent = "${selectRandomText(subjects)} ${selectRandomText(verbs)} ${selectRandomText(complements)}"
    
    return new Quote(content: translateSentenceToPigLatin(randomContent).trim(), author: getRandomAuthor(authors))
}

def getRandomAuthor(listOfAuthors) {
    return listOfAuthors[new Random().nextInt(listOfAuthors.size())]
}

def translateSentenceToPigLatin(String sentence) {
    def words = []
    
    sentence.split("\\s").each{ word ->
        words.add(translateWordToPigLatin(word))
    }
    
    return words.join(' ')
}

def translateWordToPigLatin(String word) {
    if (isVowel(word[0])) {
        return word + "way"
    } else {
        def consonantsCluster = getConsonantsCluster(word)
    
        def text = word[consonantsCluster.size()..<word.size()] + consonantsCluster + 'ay'
        
        if (isUpperCase(word[0])) {
            return text.capitalize()
        } else {
            return text
        }
    }
}

def getConsonantsCluster(word) {
    if (word) {
        def consonantsCluster = word[0]
    
        for (character in word[1..<word.size()]) {
            if (! isVowel(character)) {
                consonantsCluster += character
            } else {
                break
            }
        }
            
        return consonantsCluster
    }
}

def isVowel(ch) {
    return ch?.toUpperCase() in ['A', 'E', 'I', 'O', 'U']
}

def selectRandomText(listOfTexts) {
    def randomIndex = new Random().nextInt(listOfTexts.size())

    return listOfTexts[randomIndex]
}

def isUpperCase(String text) {
    return text.toUpperCase().equals(text)
}


""