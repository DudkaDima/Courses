import { useSelector } from 'react-redux';
import React from 'react';
import UpdateUserPageAccessValidator from 'components/PageAccessValidator/UpdateUserPageAccessValidator'
import UpdateUserPage from 'pages/UpdateUser'
import PageContainer from 'components/PageContainer';

const UpdateUser = () => {

  return (
    <UpdateUserPageAccessValidator>
      <PageContainer>
        <UpdateUserPage></UpdateUserPage>
      </PageContainer>
    </UpdateUserPageAccessValidator>
    
    )
};

export default UpdateUser;