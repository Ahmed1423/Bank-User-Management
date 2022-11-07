import axios from "axios";
const base_url = "todo";

const post = (url, data) => {
    return axios.post(base_url + url, data);
}

const get = (url, data) => {
    return axios.get(base_url + url);
}

export {get, post};