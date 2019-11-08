import React from 'react';
import'./Feasts.scss';

import Add from './add/Add';
import Filter from './filter/Filter'
import FeastsList from './feasts list/FeastsList';


function Beer() {
    return (
        <div className="beer">
            <Filter />
            <div className="main">
                <Add />
                <FeastsList />
            </div>
        </div>
    );
};

export default Beer;