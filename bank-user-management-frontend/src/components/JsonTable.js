import { JsonToTable } from "react-json-to-table";
import Menu from "./Menu";
import React, { Component } from "react";

class JSONTABLE extends Component {
  constructor() {
    super();
  }

  componentWillMount() {
    this.state = {
      data: JSON.parse(sessionStorage.getItem("data")),
      text:sessionStorage.getItem("text")
    };
    console.log(this.state.data);
  }

  render() {
    return (
      <div>
        <Menu></Menu>
        <br></br>
        <b>------ {this.state.text} ------</b>
        <br />
        <br />
        <JsonToTable json={this.state.data} />
      </div>
    );
  }
}

export default JSONTABLE;
