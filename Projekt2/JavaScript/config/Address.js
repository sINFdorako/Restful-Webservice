
module.exports = (sequelize, DataTypes) => {
  return sequelize.define('address', {
    strasse: {
      type: DataTypes.STRING,
      allowNull: false
    },
    postleitzahl: {
      type: DataTypes.INTEGER,
      allowNull: false
    },
    ort: {
      type: DataTypes.STRING,
      allowNull: false
    }
  });
};
