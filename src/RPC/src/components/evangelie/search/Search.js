import React from 'react';
import Styles from './Search.module.scss';

function Search(props) {
    return (
        <div className={Styles.search}>
            <input className={Styles.search__input} onInput={(e) => props.search(e.target.value)}></input>
            <button className={Styles.search__btn}>Найти</button>
        </div>
    );
}

export default Search;