import React from 'react';

import './Form.scss';

class Form extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            username: "",
            password: "",
            error: {
                display: "none",
                text: ""
            }
        }

        this.setUsername = this.setUsername.bind(this);
        this.setPassword = this.setPassword.bind(this);
        this.showError = this.showError.bind(this);
        this.hideError = this.hideError.bind(this);
        this.register = this.register.bind(this);
    }

    render() {
        return (
            <div className="form">
                <p className="form__title">Регистрация</p>
                <input className="form__input" type="text" placeholder="Логин или email.." onInput={e => this.setUsername(e.target.value)}></input>
                <input className="form__input" type="password" placeholder="Пароль" onInput={e => this.setPassword(e.target.value)}></input>
                <p className="form__error" style={{ display: this.state.error.display }}>{this.state.error.text}</p>
                <button className="form__btn" onClick={this.register}>Регистрация</button>
            </div>
        );
    }

    setUsername(name) {
        this.setState({ username: name });
    }

    setPassword(pass) {
        this.setState({ password: pass });
    }

    showError(textErr) {
        this.setState({
            error: {
                display: "block",
                text: textErr
            }
        });
    }

    hideError() {
        this.setState({
            error: {
                display: "none",
                text: ""
            }
        });
    }

    register() {
        this.hideError();

        if (this.state.username === "" && this.state.password === "") {
            this.showError("Введите логин и пароль");
        } else if (this.state.username === "" && this.state.password !== "") {
            this.showError("Введите логин");
        } else if (this.state.username !== "" && this.state.password === "") {
            this.showError("Введите пароль");
        } else {
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
                } else {
                    switch (resp.status) {
                        case 400: this.showError("Такой пользователь уже существует");
                            break;
                    }
                }
            });
        }
    }
}

export default Form;