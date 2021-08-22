import React from 'react'
import {Alert, Button, Form} from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css'
import APIService from "./service/APIService";

export default class EasyExpressionComponent extends React.Component {

    state = {
        previousFirstParameter: '',
        previousSecondParameter: '',
        firstParameter: '',
        secondParameter: '',
        resultBoolean: null
    }

    handleSubmit = event => {
        event.preventDefault();
        if (event.target.result.value !== '') {
            this.setState({
                previousFirstParameter : this.state.firstParameter,
                previousSecondParameter : this.state.secondParameter

            })

            APIService.post(`api/v1`, {
                firstParameter: this.state.firstParameter,
                secondParameter: this.state.secondParameter,
                userResult: event.target.result.value
            })
                .then(res => {
                    this.setState({
                        resultBoolean: res.data
                    })
                    event.target.result.value = ''
                });
            this.componentDidMount()
        }
    }

    componentDidMount(){
        APIService.get('/api/v1/easy')
            .then(res => {
                this.setState({firstParameter: res.data.firstParameter, secondParameter: res.data.secondParameter})
            })
            .catch(function (ex) {
                console.log('Response parsing failed. Error: ', ex);
            });
    }

    render() {
        return (
            <Form onSubmit={this.handleSubmit}>
                <Form.Group controlId="formExpression">
                    <Form.Label class="display-4">{this.state.firstParameter} * {this.state.secondParameter}</Form.Label>
                    <Form.Control type="number" name="result"/>
                </Form.Group>
                <br/>
                <Button variant="primary" type="submit" size="lg">Check</Button>
                {this.state.resultBoolean && <Alert variant="success">It's correct! <br/>
                {this.state.previousFirstParameter} * {this.state.previousSecondParameter} = {this.state.previousFirstParameter * this.state.previousSecondParameter}
                </Alert>}
                {this.state.resultBoolean === false && <Alert variant="danger">It's wrong :(<br/>
                    Correct is {this.state.previousFirstParameter} * {this.state.previousSecondParameter} = {this.state.previousFirstParameter * this.state.previousSecondParameter}</Alert>}
            </Form>
        )
    }
}