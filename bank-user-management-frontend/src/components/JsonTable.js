import { JsonToTable } from "react-json-to-table";
import React, { Component } from "react";

class JSONTABLE extends Component {
  componentWillMount() {
    this.state = {
      data: JSON.parse(sessionStorage.getItem("data")),
      text: sessionStorage.getItem("text"),
    };
    console.log(this.state.data);
  }

  render() {
    return (
      <div className="container">
        <b>------ {this.state.text} ------</b>
        <br />
        <br />
        <JsonToTable json={this.state.data} />
      </div>
    );
  }
}

export default JSONTABLE;
