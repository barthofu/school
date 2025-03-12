const sonneries = [
    new Audio('../assets/totaly_spies.mp3'),
    new Audio('../assets/captain_alerte_reveil.mp3'),
    new Audio('../assets/brice_de_nice.mp3'),
]

class Alarm {
    
    id = Math.random().toString(16).slice(2)
    time
    label
    sound
    enabled = true

    constructor(time, label, sound = 0) {
    
        this.time = time
        this.label = label
        this.sound = sound
    }

    enable () {
        this.enabled = true
    }

    mustRing () {
        return this.enabled && this.time === new Date().toLocaleTimeString().split(':').slice(0, 2).join(':')
    }

    ring () {

        // on désactive l'alarme
        this.enabled = false
        this.getDOMElement().querySelector('.alarm-enabled').checked = false
        
        // on joue le son
        sonneries[this.sound].play()
        console.log('Alarm : ' + this.label)
    }

    getDOMElement () {
        return document.getElementById(this.id)
    }

    setEvents () {

        const DOMElement = this.getDOMElement()

        // time
        DOMElement.querySelector('.alarm-time').addEventListener('change', (e) => {
            this.time = e.target.value
        })

        // label
        DOMElement.querySelector('.alarm-label').addEventListener('change', (e) => {
            this.label = e.target.value
        })

        // sound
        DOMElement.querySelector('.alarm-sound').addEventListener('change', (e) => {
            this.sound = e.target.value
        })

        // enabled
        DOMElement.querySelector('.alarm-enabled').addEventListener('change', (e) => {
            this.enabled = e.target.checked
        })

        // delete button
        DOMElement.querySelector('.alarm-delete').addEventListener('click', (e) => {
            horloge.removeAlarm(this.id)
        })
    }

    render () {
        return `
            <form class="alarm-form">
                <div class="formField">
                    <label for="alarm-time">Heure</label>
                    <input type="time" class="alarm-time" name="alarm-time" value="${this.time}">
                </div>
                <div class="formField">
                    <label for="alarm-label">Label</label>
                    <input type="text" class="alarm-label" name="alarm-label" value="${this.label}">
                </div>
                <div class="formField">
                    <label for="alarm-sound">Son</label>
                    <select class="alarm-sound" name="alarm-sound">
                        <option value="0" ${this.sound === 0 ? 'selected' : ''}>Totaly Spies</option>
                        <option value="1" ${this.sound === 1 ? 'selected' : ''}>Captain Alerte Réveil</option>
                        <option value="2" ${this.sound === 2 ? 'selected' : ''}>Brice de Nice</option>
                    </select>
                </div>
                <div class="formField">
                    <label for="alarm-enabled">Activé</label>
                    <input type="checkbox" class="alarm-enabled" name="alarm-enabled" ${this.enabled ? 'checked' : ''}>
                </div>
                <div class="formField">
                    <button type="button" class="alarm-delete">Supprimer</button>
                </div>
            </form>
        `
    }

}

class Horloge {

    // constants
    alarmsDiv = document.querySelector('.alarms')

    // variables
    currentTime = new Date()
    alarms = []

    update () {
        this.currentTime = new Date()
        this.render()
    }

    getAlarm (id) {
        for (const alarm of this.alarms) {
            if (alarm.id === id) {
                return alarm
            }
        }
        return null
    }

    addAlarm (time, label, sound) {

        const alarm = new Alarm(time, label, sound)
        this.alarms.push(alarm)

        const node = document.createElement('div')
        node.classList.add('alarm')
        node.id = alarm.id
        node.innerHTML = alarm.render()
        this.alarmsDiv.appendChild(node)
        alarm.setEvents()
    }

    removeAlarm (id) {

        const alarm = this.getAlarm(id)
        if (alarm) {

            this.alarmsDiv.removeChild(alarm.getDOMElement())
            
            this.alarms.splice(this.alarms.indexOf(alarm), 1)
        }
    }

    checkAlarms () {
        for (const alarm of this.alarms) {
            if (alarm.mustRing()) {
                alarm.ring()
            }
        }
    }

    render () {
        const horloge = document.querySelector('#horloge')
        horloge.innerHTML = this.toString()
    }

    toString () {
        return this.currentTime.toLocaleTimeString()
    }

}