function ex2 () {

    // Q. 1
    countVoyellesAndConsonnes(prompt("Mot"))
    
    const array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    
    // Q. 2
    findMinAndMax(array)

    // Q. 3
    average(array)

    // Q.4
    verifyPINIsValid(prompt("PIN"))

    // Q.5
    convertCase(prompt("Mot"))

}

function countVoyellesAndConsonnes (word) {

    // 1. Avec regex

    const voyellesRegex = /[aeiouyAEIOUY]/gi

    alert(`Il y a ${word.match(voyellesRegex).length} voyelles et ${word.length - word.match(voyellesRegex).length} consonnes dans le mot ${word}`)

    // 2. Sans regex

    const voyelles = ['a', 'e', 'i', 'o', 'u', 'y']
    let countVoyelles = 0

    for (const letter of word) {
        if (voyelles.includes(letter)) countVoyelles++
    }

    alert(`Il y a ${countVoyelles} voyelles et ${word.length - countVoyelles} consonnes dans le mot ${word}`)
}

function findMinAndMax (array) {

    const min = Math.min(...array)
    const max = Math.max(...array)

    alert(`Le plus petit est ${min} et le plus grand est ${max}`)
}

function average (array) {

    const average = array.reduce((acc, curr) => acc + curr) / array.length

    alert(`La moyenne est ${average}`)
}

function verifyPINIsValid (pin) {

    const regex = /^\d{4}$|^\d{6}$/,
          isValid = regex.test(pin)

    alert(`Le PIN est ${isValid ? 'valide' : 'invalide'}`)
}

function convertCase (word) {

    alert(word.toLowerCase())
    alert(word.toUpperCase())
}