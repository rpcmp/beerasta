import React from 'react';
import './login.scss';
import {NavLink} from "react-router-dom"

class Login extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            username: "",
            password: "",
            errorDisplay: "none",
            error: ""
        };

        this.login = this.login.bind(this);
        this.setUsername = this.setUsername.bind(this);
        this.setPassword = this.setPassword.bind(this);
        this.showError = this.showError.bind(this);
    }

    componentDidMount(){
        if (localStorage.getItem("user") != undefined){
            this.props.history.push("/user");
        }
    }

    render() {
        return (
            <div className="login">
                <div className="form">
                    <p className="title">Логин</p>
                    <div className="item">
                        <input className="input" placeholder="username" onInput={e => this.setUsername(e.target.value)}></input>
                    </div>
                    <div className="item">
                        <input className="input" type="password" placeholder="password" onInput={e => this.setPassword(e.target.value)}></input>
                    </div>
                    <div className="item" style={{display: this.state.errorDisplay}}>
                        <p className="error">{this.state.error}</p>
                    </div>
                    <div className="item btn-container">
                        <button className="btn btn-login" onClick={this.login}>Войти</button>
                        <NavLink to="/register" className="btn btn-register">Регистрация</NavLink>
                    </div>
                </div>
            </div>
        );
    }

    setUsername(name) {
        this.setState({ username: name });
    }

    setPassword(pass) {
        this.setState({ password: pass });
    }

    showError(err) {
        this.setState({
            errorDisplay: "block",
            error: err
        });
    }

    login() {
        fetch("https://beerasta.herokuapp.com/login?username=" + this.state.username + "&password=" + this.state.password,
            {
                method: 'POST'
            }).then(resp => {
                if (resp.ok) {
                    localStorage.setItem("user", this.state.username);
                    this.props.history.push("/user");
                } else {
                    this.showError(resp.statusText);
                }
            });
    }
}

export default Login;