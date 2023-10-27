const express = require('express')
const formationModel = require('../models/formation')
const app = express()
var bodyParser = require('body-parser')

app.use(express.static(__dirname + '/public'))

app.use(
  bodyParser.urlencoded({
    extended: false
  })
)

app.use(bodyParser.json())

app.post('/formation', async (request, response) => {
  const formation = new formationModel(request.body)

  await formation.save()
  response.send(formation)
})

app.get('/formation', async (request, response) => {
  const formations = await formationModel.find({})

  response.send(formations)
})
app.put("/update/:id", async (request, response) => {
  try {
    const id = request.params.id;
    const newData = request.body;
    const updated = await formationModel.findByIdAndUpdate(id, newData, { new: true });

    if (!updated) {
      return response.status(404).send({ message: 'Formation not found' });
    }

    response.status(200).send(updated);
  } catch (error) {
    response.status(400).send(error);
  }
});
app.delete('/formation/:id', async (request, response) => {
  const formation = await formationModel.findByIdAndDelete(request.params.id)

  if (!formation) response.status(404).send('No item found')
  response.status(200).send()
})

app.get('/formation/:id', async (request, response) => {
  try {
    const formation = await formationModel.findById(request.params.id);

    if (!formation) {
      response.status(404).send('No item found');
    } else {
      response.status(200).json(formation); // Vous pouvez envoyer la formation en tant que JSON
    }
  } catch (error) {
    response.status(500).send('Internal Server Error'); // Gérer les erreurs
  }
});

module.exports = app
