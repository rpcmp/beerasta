import React from 'react';
import Styles from './Settings.module.scss';

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
        console.log(Styles);
        return (
            <div className={Styles.info}>
                <div className={Styles.list}>
                    <div className={Styles.item}>
                        <p className={Styles.item_title}>Имя фамилия</p>
                        <p className={Styles.item_text}>{this.state.user.name} Имя фамилия</p>
                        <input className={Styles.input_text} placeholder="Введите имя"></input>
                        <button className={Styles.btn_save}>Принять</button>
                    </div>
                    <div className={Styles.item}>
                        <p className={Styles.item_title}>Никнейм</p>
                        <p className={Styles.item_text}>{this.state.nickname} Никнейм</p>
                        <input className={Styles.input_text} placeholder="Введите никнейм"></input>
                        <button className={Styles.btn_save}>Принять</button>
                    </div>
                    <div className={Styles.item}>
                        <p className={Styles.item_title}>Логин</p>
                        <p className={Styles.item_text}>{this.state.login} Логин</p>
                    </div>
                    <div className={Styles.item}>
                        <p className={Styles.item_title}>Email</p>
                        <p className={Styles.item_text}>{this.state.email} user@example.com</p>
                        <input className={Styles.input_text} placeholder="Введите email"></input>
                        <button className={Styles.btn_save}>Принять</button>
                    </div>
                    <div className={Styles.item}>
                        <p className={Styles.item_title}>Пароль</p>
                        <p className={Styles.item_text}>*************</p>
                        <input className={Styles.input_text} placeholder="Введите старый пароль" type="password"></input>
                        <input className={Styles.input_text} placeholder="Введите новый пароль" type="password"></input>
                        <input className={Styles.input_text} placeholder="Подвердите пароль" type="password"></input>
                        <button className={Styles.btn_save}>Принять</button>
                    </div>
                    <div className={Styles.item}>
                        <p className={Styles.item_title}>Обо мне</p>
                        <p className={Styles.item_text}>{this.state.about}Описание описание описание</p>
                        <textarea className={Styles.input_area} placeholder="Расскажите о себе..."></textarea>
                        <button className={Styles.btn_save}>Принять</button>
                    </div>
                    <div className={Styles.item}>
                        <button className={Styles.btn_save_all}>Сохранить все</button>
                    </div>
                </div>
                <div className={Styles.userpic}>
                    <img className={Styles.userpic_img} src={Userpic} alt="userpic"></img>
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