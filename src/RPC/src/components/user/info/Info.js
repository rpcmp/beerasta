import React from 'react';
import './Info.scss';

import Userpic from './img/userpic.png';

// Имя, прозвище, логин, email, пароль, о себе, выход
class Info extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            name: "",
            nickname: "",
            login: "",
            email: "",
            about: "",
            user: {
                name: "",
                nickname: "",
                login: "",
                email: "",
                about: ""
            }
        };

        this.getUser = this.getUser.bind(this);
    }

    render() {
        return (
            <div className="info">
                <div className="list info__list">
                    <div className="list__item">
                        <p className="info__title">Имя фамилия</p>
                        <p className="info__text">{this.state.user.name} Имя фамилия</p>
                        <div className="info__change change">

                            <input className="input input_text change__input" placeholder="Введите имя"></input>
                            <button className="btn btn-save change__btn">Принять</button>
                        </div>
                    </div>
                    <div className="list__item">
                        <p className="info__title">Никнейм</p>
                        <p className="info__text">{this.state.nickname} Никнейм</p>
                        <div className="info__change change">
                            <input className="input input_text change__input" placeholder="Введите никнейм"></input>
                            <button className="btn btn-save change__btn">Принять</button>
                        </div>
                    </div>
                    <div className="list__item">
                        <p className="info__title">Логин</p>
                        <p className="info__text">{this.state.login} Логин</p>
                    </div>
                    <div className="list__item">
                        <p className="info__title">Email</p>
                        <p className="info__text">{this.state.email} user@example.com</p>
                        <div className="info__change change">
                            <input className="input input_text change__input" placeholder="Введите email"></input>
                            <button className="btn btn-save change__btn">Принять</button>
                        </div>
                    </div>
                    <div className="list__item">
                        <p className="info__title">Пароль</p>
                        <p className="info__text">*************</p>
                        <div className="info__change change">
                            <input className="input input_text change__input" placeholder="Введите старый пароль" type="password"></input>
                            <input className="input input_text change__input" placeholder="Введите новый пароль" type="password"></input>
                            <input className="input input_text change__input" placeholder="Подвердите пароль" type="password"></input>
                            <button className="btn btn-save change__btn">Принять</button>
                        </div>
                    </div>
                    <div className="list__item">
                        <p className="info__title">Обо мне</p>
                        <p className="info__text">{this.state.about}Злобный веган как нэйт диаз</p>
                        <div className="info__change change">
                            <textarea className="input input_area change__text" placeholder="Расскажите о себе..."></textarea>
                            <button className="btn btn-save change__btn">Принять</button>
                        </div>
                    </div>
                    <div className="list__item action">
                        <button className="btn btn-save_all">Сохранить все</button>
                    </div>
                </div>
                <div className="userpic info__userpic">
                    <img className="userpic__img" src={Userpic} alt="userpic"></img>
                    <div className="change userpic__change">
                        {/* todo//доделать */}
                    </div>
                </div>
            </div>
        );
    }

    getUser() {

    }
}

export default Info;