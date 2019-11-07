import React from 'react';
import './Search.scss';

function Search() {
    return (
        <div className="search">
            <input className="search__input"></input>
            <button className="search__button">Найти</button>
        </div>
    );
}

export default Search;