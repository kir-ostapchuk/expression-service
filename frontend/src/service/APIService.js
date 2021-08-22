import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:8090/",
    // baseURL: "http://multiplicationtrainer-env.eba-8serprck.us-east-2.elasticbeanstalk.com/",
    responseType: "json"
});
