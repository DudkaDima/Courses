import React from 'react';
import withAuthorities from 'decorators/withAuthorities';
import Users from './containers/Users';



export default withAuthorities(props => (
    <Users {...props} />
));
