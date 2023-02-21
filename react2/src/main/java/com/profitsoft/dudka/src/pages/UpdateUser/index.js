import React from 'react';
import withAuthorities from 'decorators/withAuthorities';
import UpdateUser from './container/UpdateUser';



export default withAuthorities(props => (
    <UpdateUser {...props} />
));
