import axios from "axios";

const base_url = "http://localhost:8080";

const post = async (url, data) => {
  console.log(base_url + url, data);
  let a = await axios.post(base_url + url, data);
  return a;
};

const get = (url, data) => {
  return axios.get(base_url + url,{params: data});
};

export { get, post };
