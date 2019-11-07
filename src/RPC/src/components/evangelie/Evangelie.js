import React from 'react';
import './Evangelie.scss';

import Search from './search/Search';
import Text from './text/Text';

function Evangelie() {
    return (
        <div className="doctrine">
            <Search />
            <Text />
        </div>
    );
} 

export default Evangelie;