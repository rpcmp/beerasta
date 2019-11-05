import React from 'react';
import './beer.scss';
import Filter from './filter/filter'
import Add from './add/add';
import Items from './main/index';


function Beer(){
    return (
        <div className="beer">
            <Filter/>
            <div className="main">
                <Add/>
                <Items/>
            </div>
        </div>
    );
};

export default Beer;