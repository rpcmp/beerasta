import React from 'react';
import './Evangelie.scss';

import Search from './search/Search';
import Chapter from './chapter/Chapter';

function Evangelie() {
    return (
        <div className="doctrine">
            <Search />
            <Chapter 
            title="test title"
            text="test text" />
        </div>
    );
} 

export default Evangelie;