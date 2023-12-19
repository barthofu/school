const config = {

    thickness: 2,
    color: 'black'
}

const canvas = document.querySelector('#canvas'),
      ctx = canvas.getContext('2d')

let mouseDown = false

canvas.width = window.innerWidth
canvas.height = window.innerHeight

document.body.onmousedown = () => { mouseDown = true }
document.body.onmouseup = () => { mouseDown = false }

function loop () {


    if (mouseDown) {

        // On récupère les coordonnées du clic
        const x = event.clientX,
              y = event.clientY

        // On dessine un cercle
        drawCircle(ctx, x, y, config.thickness, config.color)
    }

    window.requestAnimationFrame(loop)
}

loop()

// Fonction utilitaire afin de dessiner un cercle
function drawCircle(ctx, x, y, radius, fill, stroke, strokeWidth) {

    ctx.beginPath()
    ctx.arc(x, y, radius, 0, 2 * Math.PI, false)

    if (fill) {
        ctx.fillStyle = fill
        ctx.fill()
    }

    if (stroke) {

        ctx.lineWidth = strokeWidth
        ctx.strokeStyle = stroke
        ctx.stroke()
    }
}