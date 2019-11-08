import React from 'react';
import './Filter.scss';

function Filter() {
    return (
        <div className="filter">
            <div className="filter__item">
                <h2 className="filter__title">Искать пирушку</h2>
            </div>
            <div className="filter__item">
                <p>Адрес</p>
                <input className="filter__input input input_text" placeholder="Адрес"></input>
            </div>
            <div className="filter__item">
                <p>Количество людей</p>
                <input className="filter__input input input_half" placeholder="Min"></input>
                <input className="filter__input input input_half" placeholder="Max"></input>
            </div>
            <div className="filter__item">
                <p>Время начала</p>
                <input type="time" className="filter__input input input_time"></input>
            </div>
            <div className="filter__item">
                <button className="filter__btn btn">Найти</button>
            </div>
        </div>
    );
}

export default Filter;