import React from 'react';
import './register.scss';

class Register extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            username: "",
            password: ""
        };

        this.setUsername = this.setUsername.bind(this);
        this.setPassword = this.setPassword.bind(this);
        this.register = this.register.bind(this);
    }

    render() {
        return (
            <div className="register">
                <div className="form">
                    <p className="title">Регистрация</p>
                    <div className="item">
                        <input className="input" placeholder="username" onInput={e => this.setUsername(e.target.value)}></input>
                    </div>
                    <div className="item">
                        <input className="input" type="password" placeholder="password" onInput={e => this.setPassword(e.target.value)}></input>
                    </div>
                    <div className="item" style={{ display: this.state.errorDisplay }}>
                        <p className="error">{this.state.error}</p>
                    </div>
                    <div className="item btn-container">
                        <button className="btn btn-login" onClick={this.register}>Регистрация</button>
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

    register() {
        let body = { username: this.state.username, password: this.state.password }

        fetch("https://beerasta.herokuapp.com/registration", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        }).then(resp => {
            if (resp.ok) {
                this.props.history.push("/login");
            }
        });
    }
}

export default Register;