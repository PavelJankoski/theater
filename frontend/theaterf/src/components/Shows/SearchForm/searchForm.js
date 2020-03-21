import React from 'react';

const SearchForm = (props) => {

    const onSearch = (e) => {
        e.preventDefault();
        props.onSearch(e.target["searchTerm"].value);

    }

    return (
        <form onSubmit={onSearch}>
            <div className="tb">
                <div className="td tdi"><input type="text" id="search" name={"searchTerm"} placeholder="Search" aria-label="Search" required/></div>
                <div className="td" id="s-cover">
                    <button type="submit">
                        <div id="s-circle"></div>
                        <span id="btnSpan"></span>
                    </button>
                </div>
            </div>
        </form>
    )
}

export default SearchForm;