import React from 'react';
import Styles from './Feast.module.scss';

import Beer from './img/beer.png';

class Feast extends React.Component {
    constructor(props) {
        super(props);

        this.book = this.book.bind(this)
    }

    // name - адрес. Количество человек, длительность, уровень алкогольности напитков, скок вкидываться
    render() {
        return (
            <div className={Styles.feast}>
                <img className={Styles.img} src={Beer} alt="beer"></img>
                <div className={Styles.info}>
                    <h3 className={Styles.text_title}>{this.props.address}</h3>
                    <p className={Styles.text_time}>Время начала: {this.props.time}</p>
                    <p className={Styles.text_about}>{this.props.about}</p>
                </div>
                <div className={Styles.action}>
                <button className={Styles.btn_book}>Пирую!</button>
                    <button className={Styles.btn_delete}>Удалить!</button>
                </div>
            </div>
        )
    }

    book() {
        fetch(`https://beerasta.herokuapp.com/user/booked?username=${localStorage.getItem("user")}&itemId=${this.props.id}`, {
            method: 'POST'
        }).then(res => {
            if (res.ok) {
                alert('Тебя уже ждут на встрече!')
            }
        })
    }
}

export default Feast;