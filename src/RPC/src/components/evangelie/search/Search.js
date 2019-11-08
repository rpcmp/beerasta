import React from 'react';
import Styles from './Search.module.scss';

function Search() {
    return (
        <div className={Styles.search}>
            <input className={Styles.search__input}></input>
            <button className={Styles.search__btn}>Найти</button>
        </div>
    );
}

export default Search;