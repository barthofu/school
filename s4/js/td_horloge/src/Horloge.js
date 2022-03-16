class Alarm {

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
        return this.enabled && this.time <= Date.now()
    }

    ring () {
        // TODO : play sound
        //console.log('Alarm : ' + this.label)
    }

    render () {
        return `
            <form class="alarm-form">
                <div class="alarm-time">
                    <label for="alarm-time">Heure</label>
                    <input type="time" id="alarm-time" name="alarm-time" value="${this.time}">
                </div>
                <div class="alarm-label">
                    <label for="alarm-label">Label</label>
                    <input type="text" id="alarm-label" name="alarm-label" value="${this.label}">
                </div>
                <div class="alarm-sound">
                    <label for="alarm-sound">Son</label>
                    <select id="alarm-sound" name="alarm-sound">
                        <option value="0" ${this.sound === 0 ? 'selected' : ''}>Aucun</option>
                        <option value="1" ${this.sound === 1 ? 'selected' : ''}>Bruitage 1</option>
                        <option value="2" ${this.sound === 2 ? 'selected' : ''}>Bruitage 2</option>
                    </select>
                </div>
                <div class="alarm-enabled">
                    <label for="alarm-enabled">Activé</label>
                    <input type="checkbox" id="alarm-enabled" name="alarm-enabled" ${this.enabled ? 'checked' : ''}>
                </div>
                <div class="alarm-buttons">
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

    getAlarm (position) {
        return this.alarms[position]
    }

    addAlarm (time, label, sound) {

        const alarm = new Alarm(time, label, sound)
        this.alarms.push(alarm)

        const node = document.createElement('div')
        node.classList.add('alarm')
        node.innerHTML = alarm.render()
        this.alarmsDiv.appendChild(node)
    }

    removeAlarm (position) {

        this.alarms.splice(position, 1)

        this.alarmsDiv.removeChild(alarmsDiv.children[position])
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