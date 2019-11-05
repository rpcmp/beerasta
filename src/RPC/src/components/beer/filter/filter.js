import React from 'react';
import './filter.scss';

function Filter() {
    return (
        <div className="filter">
            <div className="item">
                <h2 className="title">Искать пирушку</h2>
            </div>
            <div className="item">
                <p>Адрес</p>
                <input className="input input-text"></input>
            </div>
            <div className="item">
                <p>Количество людей</p>
                <div className="half-container">
                    <input className="input input-half" placeholder="Min"></input>
                    <input className="input input-half" placeholder="Max"></input>
                </div>
            </div>
            <div className="item">
                <p>Время начала</p>
                <input type="time" className="input input-time"></input>
            </div>
            <div className="item">
                <button className="submit">Найти</button>
            </div>
        </div>
    );
}

export default Filter;