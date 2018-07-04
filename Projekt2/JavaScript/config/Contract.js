
module.exports = (sequelize, DataTypes) => {
  return sequelize.define('contract', {
    vertragsnummer: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    vertragsart: {
      type: DataTypes.STRING,
      allowNull: false
    },
    id: {
      type: DataTypes.INTEGER,
      allowNull: false,
      primaryKey: true
    },
    jahresbeitrag: {
      type: DataTypes.INTEGER,
      allowNull: false
    }
  });
};
