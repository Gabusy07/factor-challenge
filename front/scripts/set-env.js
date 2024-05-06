const { writeFile } = require("fs");
const packageJson = require("../package.json");
const STAGE = process.env.NODE_ENV || "dev";

const defaultConfigFile = require(`../src/environments/config`);
const currentConfigFile = require(`../src/environments/config.${STAGE}`);
const envConfig = require("dotenv").config({ path: `./.env.${STAGE}` });
const targetPath = `./src/environments/environment.${STAGE}.ts`;

function writeFileUsingFS(targetPath, environmentFileContent) {
  writeFile(targetPath, environmentFileContent, function (err) {
    if (err) {
      console.log(err);
    }
    if (environmentFileContent !== "") {
      console.log(`wrote variables to ${targetPath}`);
    }
  });
}

let environment = { ...defaultConfigFile, ...currentConfigFile };
for (let key in envConfig.parsed) {
  environment[key] = envConfig.parsed[key];
}
environment = { ...environment, version: packageJson.version };

const environmentFileContent = `
  export const environment = ${JSON.stringify(environment)};
`;

writeFileUsingFS(targetPath, environmentFileContent);
