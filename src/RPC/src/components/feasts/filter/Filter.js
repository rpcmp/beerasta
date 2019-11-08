import React from 'react';
import Styles from './Filter.module.scss';

function Filter() {
    console.log(Styles);
    return (
        <div className={Styles.filter}>
            <div className={Styles.item}>
                <h2 className={Styles.title}>Искать пирушку</h2>
            </div>
            <div className={Styles.item}>
                <p className={Styles.title}>Адрес</p>
                <input className={Styles.input_text} placeholder="Адрес"></input>
            </div>
            <div className={Styles.item}>
                <p className={Styles.title}>Количество людей</p>
                <input className={Styles.input_half} placeholder="Min"></input>
                <input className={Styles.input_half} placeholder="Max"></input>
            </div>
            <div className={Styles.item}>
                <p className={Styles.title}>Время начала</p>
                <input type="time" className={Styles.input_time}></input>
            </div>
            <div className={Styles.item}>
                <button className={Styles.btn}>Найти</button>
            </div>
        </div>
    );
}

export default Filter;