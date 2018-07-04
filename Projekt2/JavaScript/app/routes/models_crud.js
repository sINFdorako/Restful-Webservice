module.exports = function(app, sequelize){


  const Address = sequelize.import('../../config/Address.js');
  const Customer = sequelize.import('../../config/Customer.js');
  const Contract = sequelize.import('../../config/Contract.js');

  Address.sync();
  Customer.sync();
  Contract.sync();

  Address.belongsTo(Customer);
  Customer.hasMany(Contract);

  //Create new Customer

  app.post("/Customer", (req, res) =>{

     const vorname = req.body.vorname;
     const nachname = req.body.nachname;
     const id = req.body.id;
     const geburtstag = req.body.geburtstag;
     Customer.create({
       vorname: 'Dominik',
       nachname: 'Rakowski',
       id: '742-846-341',
       geburtstag: '1997-12-30'
     })
       .then(newCustomer => {
         res.json(newCustomer);
       })


       //Create Address
          const strasse = req.body.strasse;
          const postleitzahl = req.body.postleitzahl;
          const ort = req.body.ort;
          Address.create({
            strasse: 'Ahornstraße 5a',
            postleitzahl: '83253',
            ort: 'Rimsting'
          })
            .then(newAddress => {
              res.json(newAddress);
            })

  });


  //Create new Contract


  app.post("/Contract", (req, res) =>{


       const vertragsnummer = req.body.vertragsnummer;
       const vertragsart = req.body.vertragsart;
       const id = req.body.id;
       const jahresbeitrag = req.body.jahresbeitrag;
       Contract.create({
         vertragsnummer: '2135413245',
         vertragsart: 'Vollkaskoversicherung',
         id: '123-123-123',
         jahresbeitrag: '645'
       })
         .then(newContract => {
           res.json(newContract);
         })
       })


    //patch single Customer

    app.patch('/Customer/:id', (req, res) => {
    const id = req.params.id;
    const updates = req.body.updates;
    Customer.find({
      where: { id: id }
    })
      .then(customer => {
        return customer.updateAttributes(updates)
      })
      .then(updatedCustomer => {
        res.json(updatedCustomer);
      });
  });

  //patch single Contract

  app.patch('/Contract/:id', (req, res) => {
    const id = req.params.id;
    const updates = req.body.updates;
    Contract.find({
      where: { id: id }
    })
      .then(contract => {
        return contract.updateAttributes(updates)
      })
      .then(updatedContract => {
        res.json(updatedContract);
      });
  });

  //Search for all Customers
  app.get('/Customer', (req, res) => {
    Customer.findAll()
      .then(c => {
        res.json(c);
      });
  });

  //Search for Customer by ID
  app.get('/Customer/:id', (req, res) => {
    const id = req.params.id;
    Customer.find({
      where: { id: id }
    })
      .then(c => {
        res.json(c);
      });
  });


  //Search for all Contracts
  app.get('/Contract', (req, res) => {
    Contract.findAll()
      .then(c => {
        res.json(c);
      });
  });

  //Search for Contract by ID
  app.get('/Contract/:id', (req, res) => {
    const id = req.params.id;
    Contract.find({
      where: { id: id }
    })
      .then(c => {
        res.json(c);
      });
  });


  //Delete single Customer
    app.delete('/Customer/:id', (req, res) => {
     const id = req.params.id;
     Customer.destroy({
       where: { id: id }
     })
       .then(deletedCustomer => {
         res.json(deletedCustomer);
       });
   });

  // DELETE single Contract
     app.delete('/Contract/:id', (req, res) => {
       const id = req.params.id;
       Contract.destroy({
         where: { id: id }
       })
         .then(deletedContract => {
           res.json(deletedContract);
         });
     });


}
