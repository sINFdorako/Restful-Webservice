const express     = require ('express');
const Sequelize   = require ('sequelize');
const BodyParser  = require('body-parser');
const db          = require('./config/db');

const app         = express();

const port        = 8000;


app.use(BodyParser.urlencoded({ extended: true }));


const sequelize = new Sequelize('database', 'username', 'password', {
  host: 'localhost',
  dialect:'sqlite',
  operatorsAliases: false,

  pool: {
    max: 5,
    min: 0,
    acquire: 30000,
    idle: 10000
  },

  // SQLite only
  storage: 'config/db.js'
});
require('./app/routes/models_crud.js')(app, sequelize);

// const Address = sequelize.import('./config/Address.js');
// const Customer = sequelize.import('./config/Customer.js');
// const Contract = sequelize.import('./config/Contract.js');

sequelize
  .authenticate()
  .then(() => {
    console.log('Connection has been established successfully.');
  })
  .catch(err => {
    console.error('Unable to connect to the database:', err);
  });

  app.listen(port, () => {
    console.log("Your server is running on port " +port);
  })
