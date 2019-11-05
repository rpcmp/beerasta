import React from 'react';
// import Alco from './img/alco.png';
import './item.scss';

class Item extends React.Component {
    constructor(props) {
        super(props);

        this.book = this.book.bind(this)
    }

    book(){
        fetch(`https://beerasta.herokuapp.com/user/booked?username=${localStorage.getItem("user")}&itemId=${this.props.id}`,{
            method: 'POST'
        }).then(res => {
            if(res.ok){
                alert('Тебя уже ждут на встрече!')
            }
        })
    }

    // name - адрес. Количество человек, длительность, уровень алкогольности напитков, скок вкидываться
    render() {
        return (
            <div className="item">
                <p className="address">{this.props.address}</p>
                <div className="people">
                    <p>{`Численность: ${this.props.min}...${this.props.max}`}</p>
                </div>
                <div className="time">
                    <p>Начало: {this.props.time}</p>
                </div>
                <button className="accept" onClick={this.book}>
                    Пирую
                </button>
            </div>
        )
    }
}

export default Item;