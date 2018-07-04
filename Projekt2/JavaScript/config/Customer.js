module.exports = (sequelize, DataTypes) => {
  return sequelize.define('customers', {
    vorname: {
      type: DataTypes.STRING,
      allowNull: false
    },
    nachname: {
      type: DataTypes.STRING,
      allowNull: false
    },
    id: {
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    geburtstag: {
      type: DataTypes.STRING,
      allowNull: false
    },

  });
};
