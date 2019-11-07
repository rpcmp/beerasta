import React from 'react';
import './Chapter.scss';

function Chapter(props){
    return(
        <div className="chapter text__chapter">
            <button className="chapter__title">{props.title}</button>
            <p className="chapter__text">{props.text}</p>
        </div>
    );
}

export default Chapter;