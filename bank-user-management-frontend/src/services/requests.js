import axios from "axios";
import { base_url } from "./constants";

const post = (url, data) => {
    return axios.post(base_url + url, data);
}

const get = (url, data) => {
    return axios.get(base_url + url);
}

export {get, post};