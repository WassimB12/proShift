const express = require('express')
const mongoose = require('mongoose')
const foodRouter = require('./routes/formationRoute.js')
const eurekaHelper = require('./eureka-helper');
const PORT = process.env.PORT || 4001;
const app = express()
const cors = require('cors');

app.use(express.json())
app.use(cors());

mongoose.connect(
  'mongodb+srv://wided:wided@cluster0.cig5jva.mongodb.net/?retryWrites=true&w=majority',

  {
    useNewUrlParser: true,
    useFindAndModify: false,
    useUnifiedTopology: true
  }
)

app.use(foodRouter)

app.listen(4001, () => {
  console.log('Server is running...')
})

eurekaHelper.registerWithEureka('formation-service', PORT);
